import { NgModule } from '@angular/core';
import { Title } from '@angular/platform-browser';

import {
    HolyfamilySharedLibsModule,
    JhiAlertComponent,
    JhiAlertErrorComponent
} from './';

@NgModule({
    imports: [
        HolyfamilySharedLibsModule
    ],
    declarations: [
        JhiAlertComponent,
        JhiAlertErrorComponent
    ],
    providers: [
        Title
    ],
    exports: [
        HolyfamilySharedLibsModule,
        JhiAlertComponent,
        JhiAlertErrorComponent
    ]
})
export class HolyfamilySharedCommonModule {}
