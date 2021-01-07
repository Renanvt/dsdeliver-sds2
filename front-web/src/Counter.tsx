import { useState } from "react"

function Counter(){
    //conceito de estado no componente react
    const [counter, setCounter] = useState(5);
    const handleIncrease = () =>{
        setCounter(counter +1);
    }

    const handleDecrease = () => {
        setCounter(counter -1);
    }

    return (
        <div>
           <button onClick={handleIncrease}>Incrementar</button>
           <button onClick={handleDecrease}>Decrementar</button>
            <h1>Valor do contador: {counter}</h1>
        </div>
    );
}

export default Counter;