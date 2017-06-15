import {GET_ALL_SKILLS} from "../constants/constants";
import * as ServerApi from "../api/Api";

const getAllSkills = (allSkills) => ({
  type: GET_ALL_SKILLS,
  allSkills
});

export const fetchAllSkills = () => {
  return dispatch => ServerApi.getAllSkills()
    .then(allSkills => dispatch(getAllSkills(allSkills)));
};

