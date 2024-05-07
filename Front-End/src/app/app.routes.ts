import { Routes } from '@angular/router';
import { MidiaComponent } from './paginas/midia/midia.component';
import { HomeComponent } from './paginas/home/home.component';

export const routes: Routes = [

    {
        path:'',
        redirectTo:'home',
        pathMatch:'full'
    },

    {
        path:'home',
        component:HomeComponent
    },
    {
        path:'midia',
        component:MidiaComponent
    }
];
