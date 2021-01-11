import axios from "axios";

//Solucionar problema do localhost não detecado, network problem
//const API_URL = 'http://192.168.0.12:8090';
const API_URL= 'https://jonatan-aulas-sds2.herokuapp.com'
//Função que busca os pedidos no back end
export function fetchOrders(){
    return axios(`${API_URL}/orders`)
}