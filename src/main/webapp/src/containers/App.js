import React, { Component } from 'react';
import '../App.css';
import {connect} from 'react-redux';


class App extends Component {
  render() {
    return (
      <div className="App">
      </div>
    );
  }
}

function mapStateToProps(state) {
    return {
        allSkills: state.allSills
    }
}

export default connect(mapStateToProps)(App);
