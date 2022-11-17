import React from 'react'
import { useNavigate, useParams } from 'react-router-dom'

function Details() {
  const {id} = useParams()
  return (
    <div>
      {id}
    </div>
  )
}

export default Details