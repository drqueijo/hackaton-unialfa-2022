import React from 'react'
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import {useNavigate} from 'react-router-dom'

function CharacterCard(props) {
  const history = useNavigate()  

  return (
    <Card style={{ width: '18rem', marginBottom: 20 }}>
    <Card.Img variant="top" src={props.image} />
    <Card.Body>
      <Card.Title>{props.name}</Card.Title>
      <Card.Subtitle className="mb-2 text-muted">{props.status}</Card.Subtitle>
      <Card.Text>
        {props.location}, {props.species}
      </Card.Text>
      <Button variant="dark" onClick={() => history('/details/' + props.id)}>See details</Button>
    </Card.Body>
  </Card>

  )
}

export default CharacterCard