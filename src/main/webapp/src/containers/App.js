import React, {Component} from "react";
import "../App.css";
import {connect} from "react-redux";
import {getAllSkills} from "../actions/ActionCreators";
import {BootstrapTable, TableHeaderColumn} from "react-bootstrap-table";
import {Checkbox, Col} from "react-bootstrap";


class App extends Component {

  const allSkills = this.props.allSkills;

  componentWillMount() {
    this.props.dispatch(getAllSkills());
  }

  render() {
    return <div className = "App">
      </div>;
  }
}

function mapStateToProps(state) {
  return {
    allSkills: state.allSills
  }
}

export default connect(mapStateToProps)(App);
