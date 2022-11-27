import React, {useEffect, useState, useRef} from 'react'
import './List.css'
import {getCharacters} from '../../services/getCharacter'
import CharacterCard from '../../components/CharacterCard/CharacterCard'
import Button from 'react-bootstrap/Button'

function List() {

  const [characters, setCharacters] = useState({
    results: [],
    info: {}
  })
  const refForm = useRef();
  const [requestPage, setRequestPage] = useState(1)
  const apiRequest = async (page, event) => {
    if(event) event.preventDefault()
    let params = {
      page
    }
    if(refForm.current[0].value) {
      params = {
        ...params,
        name: refForm.current[0].value
      }
    }
    const response = await getCharacters(params)
    setCharacters(response)
    setRequestPage(page)
  }

  useEffect(() => {
    apiRequest(1)
  }, [])

  

  return (
    <div className="list">
      <section className="list__characters">
        <form ref={refForm} onSubmit={(e) => apiRequest(1, e)} className="list__characters__search">
          <input id="search" type='text' className="form-control"  placeholder="Type a character name"/>
          <Button type="submit" variant="dark">Search</Button>
        </form>
        <div className="list__characters__list">
          {characters.results.map((character) => (
            <CharacterCard
              id={character.id}
              name={character.name}
              image={character.image}
              status={character.status}
              location={character.location.name}
              gender={character.gender}
              species={character.species}
            />
          ))}
        </div>
      </section>
      <div className="list__controls">
        {characters.info.prev && ( 
          <Button onClick={() => apiRequest(requestPage - 1)} variant="secondary">Previous page</Button>
        )}
        {requestPage}
        {characters.info.next && ( 
          <Button onClick={() => apiRequest(requestPage + 1)} variant="light">Next page</Button>
        )}    
      </div>
    </div>
  )
}

export default List