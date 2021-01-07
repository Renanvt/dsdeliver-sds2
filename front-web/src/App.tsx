import './App.css';
import Hello from './Hello';
//Hello é um função, que é um componente que recebe uma mensagem como parâmetro
function App() {
  return (
    <div>
      
     <Hello message ="Jonatan"/>
     <Hello message ="Nélio"/>
     <Hello message ="SDS2"/>
     <Hello message ="DevSuperior"/>

    </div>
  );
}

export default App;
