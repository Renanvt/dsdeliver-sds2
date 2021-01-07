import { useEffect } from "react";

//Cria um tipo de dados
type Props ={
    message: string;
}
function Hello({message} : Props){

    //Faz uma ação quando o componente inicializar
    //Um componente sofre várias reenderizações ao decorrer do tempo

    useEffect(() => {
        //Chamada para API para buscar os produtos
        console.log('componente iniciou"');
        
    }, []);
    return (
        <h1>Hello {message}!</h1>
    )
}

export default Hello;