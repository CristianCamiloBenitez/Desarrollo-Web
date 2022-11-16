import {Editorial} from '../editorial/editorial'

export interface Book {
    Id: number;
    Name: string;
    Description: string;
    imageUrl: string;
    author:string;
    editorial: Editorial;
}
