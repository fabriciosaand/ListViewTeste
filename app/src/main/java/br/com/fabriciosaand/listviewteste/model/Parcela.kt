package br.com.fabriciosaand.listviewteste.model

/**
 * Created by Domi on 20/01/2018.
 */
class Parcela{

    var mesAno: String = ""
    var pago: Boolean = false

    constructor(mesAno:String, pago:Boolean){
        this.mesAno = mesAno
        this.pago = pago
    }
}