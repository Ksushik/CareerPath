import {GET_ALL_SKILLS} from '../constants/constants';

const initialState = {
    allSkills: []
};

export default function page(state=initialState, action) {
    switch(action.type) {
        case GET_ALL_SKILLS:
            return {...state, allSkills: action.allSkills }
        default:
            return state
        }
}