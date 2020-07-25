package readinglist

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class ReadingListController {

    def index() {
	    respond Book.list(params), model:[book: new Book()]
    }

  @Transactional
  def save(Book book) {
    book.reader = 'Craig'
    book.save flush:true
    redirect(action: "index")
  }
}
