package br.com.rafaelgx.javaplayground.playground.datas;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TrabalhandoComDatas {
    // Formatar datas de acordo com a mascara
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Data baseada em fuso horario
    ZonedDateTime data = ZonedDateTime.now();
    ZonedDateTime dataSaoPaulo = data.withZoneSameInstant(
            ZoneId.of("America/Sao_Paulo"));


    LocalDate dataDeCompra = LocalDate.now();
    LocalDate dataPrimeiraParcela = LocalDate.of(2025,9,28);

    // Metodos  "plus" para adicionar e "minus" para subtrair de datas.
    // Metodos  (isBefore, isAfter, isEqual) para comparar.
    LocalDate dataSegundaParcela = dataPrimeiraParcela.plusDays(30);

    // Hora
    LocalTime inicio = LocalTime.of(9,0);
    LocalTime fim = LocalTime.of(17,30);


    public TrabalhandoComDatas(LocalDate dataDeCompra, LocalDate dataPrimeiraParcela) {
        if(dataDeCompra.isEqual(LocalDate.now())) {
            IO.println("Data de compra: " + dataDeCompra);
        }
        // Duração em horas entre datas
        Duration duraçao = Duration.between(this.inicio,this.fim);

        // Periodo entre datas
        Period period = Period.between(dataDeCompra,dataPrimeiraParcela);
        String diferenca = period.getYears() + "-" + period.getMonths() + "-"  + period.getDays();
    }


}
