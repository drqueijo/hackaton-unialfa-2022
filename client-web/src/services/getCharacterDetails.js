import {Api} from './api'

export async function getCharacterDetails(id) {
    let res = null
    try {
        await Api.get(`/character/${id || 1}`).then((response) => {
            res = response.data
        }).catch((err) => {
            console.log(err)
        })
    } catch (err) {
        console.log(err)
    }

    return res
}

export async function getMultipleCharacters(characters = []) {
    let res = []
    try {
        await Api.get('/character/' + characters.join()).then((response) => {
            res = response.data
        }).catch((err) => {
            console.log(err)
        })
    } catch (err) {
        console.log(err)
    }

    return res
}