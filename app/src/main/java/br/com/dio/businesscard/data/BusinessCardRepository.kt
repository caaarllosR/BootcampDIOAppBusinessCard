package br.com.dio.businesscard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository (private val dao: BusinessCardDAO) {

        fun insert(businessCard: BusinessCard) = runBlocking {
            launch(Dispatchers.IO) {
                dao.insert(businessCard)
            }
        }

        fun deleteByCardId(cardId: Int) = runBlocking {
            launch(Dispatchers.IO) {
                dao.deleteByCardId(cardId)
            }
        }

        fun getAll() = dao.getAll()
}