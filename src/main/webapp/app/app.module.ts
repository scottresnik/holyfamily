import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2Webstorage } from 'ngx-webstorage';

import { HolyfamilySharedModule, UserRouteAccessService } from './shared';
import { HolyfamilyAppRoutingModule} from './app-routing.module';
import { HolyfamilyHomeModule } from './home/home.module';
import { HolyfamilyAdminModule } from './admin/admin.module';
import { HolyfamilyAccountModule } from './account/account.module';
import { HolyfamilyEntityModule } from './entities/entity.module';
import { customHttpProvider } from './blocks/interceptor/http.provider';
import { PaginationConfig } from './blocks/config/uib-pagination.config';

// jhipster-needle-angular-add-module-import JHipster will add new module here

import {
    JhiMainComponent,
    NavbarComponent,
    FooterComponent,
    ProfileService,
    PageRibbonComponent,
    ErrorComponent
} from './layouts';

@NgModule({
    imports: [
        BrowserModule,
        HolyfamilyAppRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-'}),
        HolyfamilySharedModule,
        HolyfamilyHomeModule,
        HolyfamilyAdminModule,
        HolyfamilyAccountModule,
        HolyfamilyEntityModule,
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        JhiMainComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        FooterComponent
    ],
    providers: [
        ProfileService,
        customHttpProvider(),
        PaginationConfig,
        UserRouteAccessService
    ],
    bootstrap: [ JhiMainComponent ]
})
export class HolyfamilyAppModule {}
