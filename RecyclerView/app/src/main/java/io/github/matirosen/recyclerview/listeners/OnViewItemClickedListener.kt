package io.github.matirosen.recyclerview.listeners

import io.github.matirosen.recyclerview.entities.Contacto

interface OnViewItemClickedListener {
    fun onViewItemDetail(contacto: Contacto)
}