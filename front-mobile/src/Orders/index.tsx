
import React, { useEffect, useState } from 'react';
import { StyleSheet, ScrollView, Alert, Text} from 'react-native';
import { TouchableWithoutFeedback } from 'react-native-gesture-handler';
import { fetchOrders } from '../api';
import Header from '../Header';
import OrderCard from '../OrderCard';
import { Order } from '../Types';

function Orders() {
  const [orders, setOrders] = useState<Order[]>([]);

  //Mostra o texto "carregando" enquanto os pedidos não estiverem prontos 
  const [isLoading, setIsLoading] = useState(false);

    //Quando o componente for montado, faz uma requisição para buscar os pedidos
    useEffect(() => {
    setIsLoading(true);
    fetchOrders()
      .then(response => setOrders(response.data))
      .catch(() => Alert.alert('Houve um erro ao buscar os pedidos!'))
      .finally(() => setIsLoading(false));
  },[]);
    return (
        <>
        <Header />
            <ScrollView style={styles.container}>
              {isLoading ? (
                <Text>Buscando pedidos...</Text>
              ) : (
                orders.map(order => (
                  <TouchableWithoutFeedback key={order.id}>
                    <OrderCard order={order} />
                  </TouchableWithoutFeedback>
                ))
              )}
            </ScrollView>
        </>
    );
}

const styles = StyleSheet.create(
  {
    container:{
        paddingRight: '5%',
        paddingLeft: '5%',
    }
  }

);

export default Orders;
