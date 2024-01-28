interface Human
{
    name : string,
}
interface Doctor extends Human
{
    speciality : string;
}
let d : Doctor = {
    name : 'Someone',
    speciality:'General'
}