import {Component, ContentChildren, Input, QueryList, ViewChildren} from '@angular/core';
import {CommonModule} from "@angular/common";
import {TabPageComponent} from "../tab-page/tab-page.component";

@Component({
  selector: 'app-custom-tab',
  standalone: true,
  imports: [
    CommonModule,
    TabPageComponent,
  ],
  templateUrl: './custom-tab.component.html',
  styleUrl: './custom-tab.component.css'
})
export class CustomTabComponent {
  @Input()
  headers:Array<string>=[];

  @ContentChildren(TabPageComponent) tabPages!: QueryList<TabPageComponent> ;

  activeTab:number = 0;


  ngAfterContentInit() {
    console.log('ngAfterContentInit');
    console.log(this.tabPages);
    const activeTabs = this.tabPages.filter(tab => tab.active);

    if (activeTabs.length === 0) {
      this.selectTab(this.tabPages.first);
    }
  }
  selectTab(tab: TabPageComponent) {
    this.tabPages.toArray().forEach(tab => (tab.active = false));
    tab.active = true;
  }
  setActiveTab(tab:number)
  {
    console.log('Active tab ',tab);
    this.activeTab =tab;
    this.selectTab(this.tabPages.toArray()[this.activeTab]);
  }
}
