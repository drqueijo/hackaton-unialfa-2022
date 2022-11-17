import {Api} from './api'

export async function getCharacters() {
    let res = []
    try {
        await Api.get('/character').then((response) => {
            res = response.data.results
        }).catch((err) => {
            console.log(err)
        })
    } catch (err) {
        console.log(err)
    }

    return res
}