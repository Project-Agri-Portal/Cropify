import { Route, Switch } from 'react-router-dom/cjs/react-router-dom.min';
import './App.css';
import Login from './components/UserAuthentication/SignIn/Login';
import Register from './components/UserAuthentication/SignUp/Register';

function App() {
  return (
    <center>
      <div className="App">
        <Switch>
          <Route path="/" component={Login} exact />
          <Route path="/register" component={Register} exact />
          {/* <Route path="*" component={NotFound} exact /> */}
        </Switch>
      </div>
    </center>
  );
}

export default App;
