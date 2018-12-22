export class User {
    
	id: number;
	name: string;
	email: string;
	pwd: string;

	constructor(
		id: number,
		name: string,
		email: string,
		pwd: string) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
	}
}