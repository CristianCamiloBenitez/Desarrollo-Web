import {Editorial} from '../editorial/editorial'

export interface Book {
    id: number;
    name: string;
    description: string;
    image_url: string;
    cantidad: number;
    author:string;
    editorial_id: number;
}
