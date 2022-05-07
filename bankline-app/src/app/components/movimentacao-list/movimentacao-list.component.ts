import { MovimementacoesService } from './../../services/movimementacoes.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movimentacao-list',
  templateUrl: './movimentacao-list.component.html',
  styleUrls: ['./movimentacao-list.component.css']
})
export class MovimentacaoListComponent implements OnInit {
  movimentacoes:any

  constructor(private movimementacoesService: MovimementacoesService) { }

  ngOnInit(): void {
    this.listMovimentacoes();
  }

  listMovimentacoes(): void {
    this.movimementacoesService.list()
      .subscribe(data => {
        this.movimentacoes = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });
  }
}
