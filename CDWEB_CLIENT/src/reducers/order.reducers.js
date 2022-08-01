import { orderConstants } from "_constants";

const initialState = {
}

export function orderReducer(state = initialState, action) {
    switch (action.type) {
        case orderConstants.CREATE_BOOKNOW_SUCCESS:
            state.bookNowItem = action.payload
            return {
                ...state,
            }
        case orderConstants.INIT_ORDER_SUCCESS:
            state.item = action.payload
            return {
                ...state,
            }
        default: return state
    }
}