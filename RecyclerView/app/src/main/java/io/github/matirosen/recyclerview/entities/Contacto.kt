package io.github.matirosen.recyclerview.entities

import android.os.Parcel
import android.os.Parcelable

class Contacto(nombre: String, ultimoMensaje: String, hora: String, idImagen: Int) : Parcelable {
    private var nombre: String
    private var ultimoMensaje: String
    private var hora: String
    private var idImagen: Int

    init {
        this.nombre = nombre
        this.ultimoMensaje = ultimoMensaje
        this.hora = hora
        this.idImagen = idImagen
    }
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(ultimoMensaje)
        parcel.writeString(hora)
        parcel.writeInt(idImagen)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contacto> {
        override fun createFromParcel(parcel: Parcel): Contacto {
            return Contacto(parcel)
        }

        override fun newArray(size: Int): Array<Contacto?> {
            return arrayOfNulls(size)
        }
    }

    fun getNombre(): String {
        return nombre
    }

    fun getUltimoMensaje(): String {
        return ultimoMensaje
    }

    fun getHora(): String {
        return hora
    }

    fun getIdImagen(): Int {
        return idImagen
    }
}