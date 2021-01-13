import axios from "axios";

//Solucionar problema do localhost não detecado, network problem
const API_URL= 'https://jonatan-aulas-sds2.herokuapp.com'
//Função que busca os pedidos no back end
export function fetchOrders(){
    return axios(`${API_URL}/orders`)
}

export function confirmDelivery(orderId: number){
    return axios.put(`${API_URL}/orders/${orderId}/delivered`);
}