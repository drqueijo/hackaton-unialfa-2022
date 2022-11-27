import React, { useEffect, useState } from 'react'
import {getMultipleCharacters} from './../../services/getCharacterDetails'
import "./Home.css"
import { Carousel } from 'antd'
import {Link} from 'react-router-dom'
import { Divider } from 'antd';


var charactersNums = [];

while(charactersNums.length < 4){
    var r = Math.floor(Math.random() * 100) + 1;
    if(charactersNums.indexOf(r) === -1) charactersNums.push(r);
}

function Home() {

  const [characters, setCharacters] = useState([])

  const getCharacters = async () => {
    const res = await getMultipleCharacters(charactersNums)
    if(res && res.length === 0) return 
    setCharacters(res)
  }

  useEffect(() => {
    getCharacters()
  })
  
  return (
    <div className="home">
      <section className="home__heading">
        WUBBA LUBBA DUB DUB
        <p>
          The Rick and Morty is based on the television show. You will have access to about hundreds of characters, images, locations and episodes. The Rick and Morty API is filled with canonical information as seen on the TV show.
        </p>
      </section>
      <Divider />
      <section className="home__carousel-head">
        Know some random characters or <Link to="/list">search one {";)"} </Link>
      </section>
      <div className="home__carousel">
        <Carousel autoplay>
          {characters && characters.map((char, index) => (
            <div className={`home__carousel__content index-${index + 1}`}>
              <img src={char.image} />
              <info>
                <h2>{char.name}</h2>
                <Link to={`/details/${char.id}`}>
                  Know this character...
                </Link>
              </info>
            </div>
          ))}
        </Carousel>
      </div>     
    </div>
  )
}

export default Home