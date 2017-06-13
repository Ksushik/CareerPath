import {GET_ALL_SKILLS} from '../constants/constants';

export function getAllSkills (skillsList) {
    return (dispatch) =>
        dispatch({
                type: GET_ALL_SKILLS,
        allSkills: skillsList
        });
}