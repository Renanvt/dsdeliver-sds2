import React from 'react';
import { NavigationContainer } from "@react-navigation/native";
import  { createStackNavigator } from '@react-navigation/stack';
import Home from "./Home";
import Orders from "./Orders";
import OrderDetails from "./OrderDetails";

{/*Adicionar a pilha de navegação no app*/}
const Stack = createStackNavigator();

{/*<NavigationContainer> Vai encapsular todas as rotas da aplicação */}

{/*<Stack.Navigator> Abstração da pilha de  rotas*/}

{/*<Stack.Screen> Defini as rotas da app*/}
function Routes() {
    return (
        <NavigationContainer>    
            <Stack.Navigator 
            headerMode="none"
            screenOptions={{
                cardStyle:{
                    backgroundColor: '#FFF'
                }
            }}
            >
                <Stack.Screen name="Home" component={Home}></Stack.Screen>
                <Stack.Screen name="Orders" component={Orders}></Stack.Screen>
                <Stack.Screen name="OrderDetails" component={OrderDetails}></Stack.Screen>

            </Stack.Navigator>
        </NavigationContainer>
    )
}

export default Routes;