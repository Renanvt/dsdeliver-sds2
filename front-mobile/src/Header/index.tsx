import React from 'react';
import { useNavigation } from '@react-navigation/native';
import { StyleSheet, Text, View, Image } from 'react-native';
import { TouchableWithoutFeedback } from 'react-native-gesture-handler';

function OrderDetails() {
    {/*Redirecionar o usuário pra página de listagem de pedido */}
    const navigation = useNavigation();
        const handleOnPress = () => {
            navigation.navigate('Home');
    }
{/*<TouchableWithoutFeedback>*Captura evento de click */}
   
    return (

        <TouchableWithoutFeedback onPress={handleOnPress}>
        <View style={styles.container}>
            <Image source={require('../assets/logo.png')} />
            <Text style={styles.text}>DS Delivery</Text>
        </View>
        </TouchableWithoutFeedback>
    );
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: '#DA5C5C',
        height: 90,
        paddingTop: 50,
        flexDirection: 'row',
        justifyContent: 'center'
    },
    text: {
        fontSize: 18,
        fontWeight: 'bold',
        lineHeight: 25,
        letterSpacing: -0.24,
        //Converter em pra px -> multiplica por 16
        //ex.: 0,015 * 16 = 0,24
        color: '#FFF',
        marginLeft: 15,
        fontFamily: 'OpenSans_700Bold'
  }
});

export default OrderDetails;
