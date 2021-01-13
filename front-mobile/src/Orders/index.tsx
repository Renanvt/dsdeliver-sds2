
import { useIsFocused, useNavigation } from '@react-navigation/native';
import React, { useEffect, useState } from 'react';
import { StyleSheet, ScrollView, Alert, Text } from 'react-native';
import { TouchableWithoutFeedback } from 'react-native-gesture-handler';
import { fetchOrders } from '../api';
import Header from '../Header';
import OrderCard from '../OrderCard';
import { Order } from '../Types';

function Orders() {
  const [orders, setOrders] = useState<Order[]>([]);

  //Mostra o texto "carregando" enquanto os pedidos não estiverem prontos 
  const [isLoading, setIsLoading] = useState(false);

   {/*Redirecionar o usuário pra página de listagem de pedido */ }
   const navigation = useNavigation();

   //Forçar o carregamento do componente
   //Toda vez que renderiza a tela de listagem de pedidos, vai mudar o valor da variável pra true ou false. Ex.: quando eu saio da tela o valor do isFocused é false, quando eu entro na tela é true
   const isFocused = useIsFocused();

    const fetchData = () => {
      setIsLoading(true);
      fetchOrders()
        .then(response => setOrders(response.data))
        .catch(() => Alert.alert('Houve um erro ao buscar os pedidos!'))
        .finally(() => setIsLoading(false));
    }
  //Quando o componente for montado, faz uma requisição para buscar os pedidos
  useEffect(() => {
    if (isFocused) {
      fetchData();
    }
  }, [isFocused]);
  const handleOnPress = (order: Order) => {
      navigation.navigate('OrderDetails',{
        order
      });
    }

  
  return (
    <>
      <Header />
      <ScrollView style={styles.container}>
        {isLoading ? (
          <Text>Buscando pedidos...</Text>
        ) : (
            orders.map(order => (
              <TouchableWithoutFeedback
               key={order.id} 
               onPress={() => handleOnPress(order)}>
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
    container: {
      paddingRight: '5%',
      paddingLeft: '5%',
    }
  }

);

export default Orders;
