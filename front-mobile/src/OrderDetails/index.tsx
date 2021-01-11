import React from 'react';
import { useNavigation } from '@react-navigation/native';
import { StyleSheet, Text, View } from 'react-native';
import Header from '../Header';

function OrderDetails() {
    {/*Redirecionar o usuário pra página de listagem de pedido */}
    const navigation = useNavigation();
    const handleOnPress = () => {
            navigation.navigate('Orders');
    }
{/*<TouchableWithoutFeedback>*Captura evento de click */}
   
    return (
        <>
        <Header />
            <View>
                <Text>Detalhes do pedido</Text>
            </View>
        </>
    );
}

const styles = StyleSheet.create({});

export default OrderDetails;
