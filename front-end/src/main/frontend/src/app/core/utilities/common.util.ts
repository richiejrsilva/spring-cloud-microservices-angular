import { apiUrls } from '../../app-config-settings/endpoint.definition';

export class CommonUtil {
	
  /**
   * Return the url used to call specific api service
   * @param name the name of the api service
   * @param apiConfig the api settings by environment
   */
  static getApiUrl(name: string) {
    return apiUrls[name] || 'URL_NOT_FOUND';
  }

}
