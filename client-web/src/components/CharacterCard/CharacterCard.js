import React from 'react'
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';

function CharacterCard(props) {
  return (
    <Card style={{ width: '18rem', marginBottom: 20 }}>
    <Card.Img variant="top" src={props.image} />
    <Card.Body>
      <Card.Title>{props.name}</Card.Title>
      <Card.Subtitle className="mb-2 text-muted">{props.status}</Card.Subtitle>
      <Card.Text>
        {props.location}, {props.species}
      </Card.Text>
      <Button variant="dark">See details</Button>
    </Card.Body>
  </Card>

  )
}

export default CharacterCard