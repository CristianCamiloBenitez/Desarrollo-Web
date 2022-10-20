import {Editorial} from '../editorial/editorial'

export interface Book {
    id: number;
    name: string;
    description: string;
    image: string;
    editorial: Editorial;
}
