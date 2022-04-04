import { useSelector } from 'react-redux';
import { Fragment } from 'react';
import Auth from './components/Auth'
import "bootstrap/dist/css/bootstrap.min.css";

function App() {

  const isAuth = useSelector(state => state.auth.isAuthenticated);

  return (
    <Fragment>
      { !isAuth && <Auth /> }
      { isAuth && <div> You have successfully loggedIn. </div>}
    </Fragment>
  );
}

export default App;
