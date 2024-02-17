
import { Component, inject, TemplateRef } from '@angular/core';

import {ModalDismissReasons, NgbDatepickerModule, NgbModal, NgbModalRef} from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-modal-demo',
  standalone: true,
  imports: [NgbDatepickerModule],
  templateUrl: './modal-demo.component.html',
  styleUrl: './modal-demo.component.css'
})
export class ModalDemoComponent {
  private modalService = inject(NgbModal);
  closeResult = '';
  modalDialog !: NgbModalRef;
  open(content: TemplateRef<any>) {
    this.modalDialog = this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' });
    this.modalDialog.result.then(
      (result) => {
        console.log('Closed ');

        this.closeResult = `Closed with: ${result}`;
      },
      (reason) => {
        console.log('dismissed ');
        this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
      },
    );
  }

  private getDismissReason(reason: any): string {
    switch (reason) {
      case ModalDismissReasons.ESC:
        return 'by pressing ESC';
      case ModalDismissReasons.BACKDROP_CLICK:
        return 'by clicking on a backdrop';
      default:
        return `with: ${reason}`;
    }
  }
  closeModal()
  {
    this.modalDialog.close();
  }
}
