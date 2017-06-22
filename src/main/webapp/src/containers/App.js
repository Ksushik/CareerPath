import React, {Component} from "react";
import "../../css/App.css";
import {connect} from "react-redux";
import {BootstrapTable, TableHeaderColumn} from "react-bootstrap-table";
import {Checkbox, Col} from "react-bootstrap";
import {fetchAllSkills} from '../actions/ActionCreators';


class App extends Component {

  constructor(props){
    super(props);

  }

  componentWillMount() {
    this.props.dispatch(fetchAllSkills());
  }


  render() {
    const allSkills = this.props.allSkills;

    console.log(allSkills);

    const data = allSkills.map((item, id) => {
      return {
        id: id,
        intern: item.instrument,
        profile: item.profile,
        enable: item.enable,
        layer:  item.layerConfigs.length === 0 ? NO_LAYERS : item.layerConfigs.map((c) => formatAmount(c.clientSWPLiquidity)).join(),
        totalLiquidity: formatAmount(item.layerConfigs.map((c) => c.clientSWPLiquidity).reduce((prevVal, curVal) => prevVal + curVal, 0)),
        minCoreSpread: item.layerConfigs.map((c) => c.minCoreSpread).join(),
        lpPool: item.lpPool.sort().join(";")
      };
    });

    return  <div className = "App">
      <BootstrapTable data={data}
                      height="100%"
                      options={options}
                      trClassName={"Table--hover"}
                      bodyContainerClass={"Table Table--hover"}>

        <TableHeaderColumn dataField="id"
                           isKey={true}
                           fixed={true}
                           hidden={true}>
          Id
        </TableHeaderColumn>

        <TableHeaderColumn dataField="intern"
                           dataAlign="center"
                           className="Table--header"
                           width="100">
          Intern Java Dev
        </TableHeaderColumn>

        <TableHeaderColumn dataField="junior"
                           dataAlign="center"
                           className="Table--header"
                           width="100">
          Junior Java Dev
        </TableHeaderColumn>

        <TableHeaderColumn dataField="regular"
                           dataAlign="center"
                           className="Table--header"
                           width="100">
          Regular Java Dev
        </TableHeaderColumn>

        <TableHeaderColumn dataField="senior"
                           dataAlign="center"
                           className="Table--header"
                           width="100">
          Senior Java Dev
        </TableHeaderColumn>

      </BootstrapTable>
    </div>;

  }
}

function mapStateToProps(state) {
  return {
    allSkills: state.allSills
  }
}

export default connect(mapStateToProps)(App);
