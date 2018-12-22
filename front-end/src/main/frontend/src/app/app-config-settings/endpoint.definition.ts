import {environment} from '../../environments/environment';

const apiGatewayPrefix = 'api/';
const auth = 'auth-service';
const item = 'item-service';
const user = 'user-service';
const shoppinglist = 'shopping-list-service';


export const apiUrls = {
  'OAUTH_SERVICE': `${environment.server}${apiGatewayPrefix}${auth}/oauth/token`,
  'ITEM_SERVICE': `${environment.server}${apiGatewayPrefix}${item}/item`,
  'USER_SERVICE': `${environment.server}${apiGatewayPrefix}${user}/user`,
  'SHOPPING_LIST_SERVICE': `${environment.server}${apiGatewayPrefix}${shoppinglist}/shoppinglist`,
};
