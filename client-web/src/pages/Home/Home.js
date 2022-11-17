import React, {useEffect, useState} from 'react'
import {getCharacters} from '../../services/getCharacter'

function Home() {

  const [characters, setCharacters] = useState([])

  const apiRequest = async () => {
    const response = await getCharacters()
    setCharacters(response)
  }

  useEffect(() => {
    apiRequest()
  }, [])

  return (
    <div className="home">
      {console.log(characters)}
      <section className="home__heading">
        WUBBA LUBBA DUB DUB
      </section>
      <section className="home__characters">
        <form className="home__characters__search">
          <input />
          <button />
        </form>
        <div className="home__characters__list">

        </div>
      </section>
    </div>
  )
}

export default Home