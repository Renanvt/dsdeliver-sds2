
import React from 'react';
import { StyleSheet, Text, View} from 'react-native';
import Header from '../Header';
import OrderCard from '../OrderCard';

function Orders() {

    return (
        <>
        <Header />
            <View style={styles.container}>
              <OrderCard />
              <OrderCard />
              <OrderCard />
              <OrderCard />
              <OrderCard />

            </View>
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
