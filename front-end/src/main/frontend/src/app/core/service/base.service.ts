import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { CommonUtil } from '../utilities/common.util';

export abstract class BaseService<T> {
	
  protected _httpClient: HttpClient;
  protected _baseUrl: string;

  private headers={
		  	headers: new HttpHeaders({
		        'Content-Type': 'application/json'
		    })
		}

  /**
   * Constructor
   * @param {string} _serviceName Service name to fetch the service url
   */
  constructor(protected serviceName: string, protected httpClient: HttpClient) {
    this._baseUrl = CommonUtil.getApiUrl(serviceName);
    this._httpClient = httpClient;
  }

  /**
   * Find all the elements
   * @param params optional parameters for the call
   * @returns gets the list of objects found
   */
  public findAll(params?: HttpParams): Observable<T | T[]> {
    return this._httpClient.get<T | T[]>(this._baseUrl, {params});
  }

  /**
   * Find an object by its identifier
   * @param id Object identifier
   * @returns gets the object found
   */
  public findById(id: any): Observable<T> {
    return this._httpClient.get<T>(`${this._baseUrl}/${id}`);
  }

  /**
   * Create the object
   * @param {T} obj Object to create
   * @returns {Observable<T>} Observable of the result
   */
  public create(obj: T | T[]): Observable<T | T[]> {
    return this._httpClient.post<T | T[]>(this._baseUrl, JSON.stringify(obj), this.headers);
  }

  /**
   * Update the object
   * @param {T} obj Object to update
   * @param {K} key Key to identify the object
   * @returns {Observable<T>} Observable of the result
   */
  public update<K extends keyof T>(obj: T, key: K): Observable<T> {
    return this._httpClient.put<T>(`${this._baseUrl}/${obj[key]}`, JSON.stringify(obj));
  }

  /**
   * Delete a specific object by id
   * @param id Object id
   * @returns {Observable<T>} Observable of the result
   */
  public remove(id: any): Observable<T> {
    return this._httpClient.delete<T>(`${this._baseUrl}/${id}`);
  }
  
  /**
   * Count a specific object occurence
   * @returns {Observable<T>} Observable of the result
   */
  public count(): Observable<T> {
    return this._httpClient.get<T>(`${this._baseUrl}/count`);
  }
  
}
