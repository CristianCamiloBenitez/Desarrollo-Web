import { Editorial } from "../editorial/editorial";
export interface Book{
    id: number;
    name: string;
    description: string;
    image_url: string;
    amount: number;
    editorial_id: Editorial;
}