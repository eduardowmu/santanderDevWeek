import { CorrentistaService } from 'src/app/services/correntista.service';
import { MovimementacoesService } from './../../services/movimementacoes.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movimentacao-list',
  templateUrl: './movimentacao-list.component.html',
  styleUrls: ['./movimentacao-list.component.css']
})
export class MovimentacaoListComponent implements OnInit {
  movimentacoes:any;
  correntistas: any;
  correntista: any={};

  constructor(
    private movimementacoesService: MovimementacoesService,
    private correntistaService: CorrentistaService,
  ) { }

  ngOnInit(): void {
    this.exibirCorrentistas();
  }

  exibirCorrentistas(): void {
    this.correntistaService.list()
      .subscribe(
        data => {
          this.correntistas = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  listMovimentacoes(): void {
    this.movimementacoesService.findByIdConta(this.correntista.id)
      .subscribe(
        data => {
          this.movimentacoes = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });

    /*this.movimementacoesService.list()
      .subscribe(data => {
        this.movimentacoes = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });*/
  }
}
