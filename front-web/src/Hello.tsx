//Cria um tipo de dados
type Props ={
    message: string;
}
function Hello({message} : Props){
    return (
        <h1>Hello {message}!</h1>
    )
}

export default Hello;