/* =============================================================
 * bootstrap-typeahead.js v2.3.2
 * http://twbs.github.com/bootstrap/javascript.html#typeahead
 * =============================================================
 * Copyright 2013 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============================================================ */


!function($){

  "use strict"; // jshint ;_;


 /* TYPEAHEAD PUBLIC CLASS DEFINITION
  * ================================= */

  var Typeaheadwu = function (element, options) {
    this.$element = $(element)
    this.options = $.extend({}, $.fn.typeaheadwu.defaults, options)
    this.matcher = this.options.matcher || this.matcher
    this.sorter = this.options.sorter || this.sorter
    this.highlighter = this.options.highlighter || this.highlighter
    this.updater = this.options.updater || this.updater
    this.source = this.options.source
    this.$menu = $(this.options.menu)
    this.shown = false
    this.delay = this.options.delay || 0
    this.listen()
  }

  Typeaheadwu.prototype = {

    constructor: Typeaheadwu

  , select: function () {
      var val = this.$menu.find('.active').attr('data-value');
      var id = this.$menu.find('.active').attr('data-id');
      
      this.$element
        .val(val)
        .change()
      this.updater(id);
      return this.hide()
    }

  , updater: function (item) {
      return item
    }

  , show: function () {
      var pos = $.extend({}, this.$element.position(), {
        height: this.$element[0].offsetHeight
      })

      this.$menu
        .insertAfter(this.$element)
        .css({
          top: pos.top + pos.height
        , left: pos.left
        })
        .show()

      this.shown = true
      return this
    }

  , hide: function () {
      this.$menu.hide()
      this.shown = false
      return this
    }

  , lookup: function (event) {
      var items
      
      this.query = this.$element.val()


      var worker = $.proxy(function(){
    	  if (!this.query || this.query.length < this.options.minLength) {
    		  return this.shown ? this.hide() : this
    	  }
    	  items = $.isFunction(this.source) ? this.source(this.query, $.proxy(this.process, this)) : this.source
        		  
    	  return items ? this.process(items) : this
      }, this);
      
      clearTimeout(this.lookupWorker);
      this.lookupWorker = setTimeout(worker, this.delay);
      
    },
  /*lookup: function (query) {
      var items;
      if (typeof(query) != 'undefined' && query !== null) {
        this.query = query;
      } else {
        this.query = this.$element.val() || this.$element.text() || '';
      }

      if (this.query.length < this.options.minLength && !this.options.showHintOnFocus) {
        return this.shown ? this.hide() : this;
      }

      var worker = $.proxy(function () {

        // Bloodhound (since 0.11) needs three arguments. 
        // Two of them are callback functions (sync and async) for local and remote data processing
        // see https://github.com/twitter/typeahead.js/blob/master/src/bloodhound/bloodhound.js#L132
        if ($.isFunction(this.source) && this.source.length === 3) {
          this.source(this.query, $.proxy(this.process, this), $.proxy(this.process, this));
        } else if ($.isFunction(this.source)) {
          this.source(this.query, $.proxy(this.process, this));
        } else if (this.source) {
          this.process(this.source);
        }
      }, this);

      clearTimeout(this.lookupWorker);
      this.lookupWorker = setTimeout(worker, this.delay);
    },*/
//---------------------------------------------------------------
    process: function (items) {
      var that = this

//      items = this.grepExt(items);
    	  
    	 /* $.grep(items, function (item) {
        return that.matchers(item)
      })*/
      if(items.length && items.length>0){
    	  items = this.sorter(items)
      }

      if (!items.length) {
        return this.shown ? this.hide() : this
      }

      return this.render(items.slice(0, this.options.items)).show()
    }
  , grepExt:function (items) {
	  var temList = [];
	  var _this = this;
	  $.each(items, function(i,item){
		  if(_this.matchers(item)){
			  temList.push(item);
		  }
	  })
	  return temList;
  }
  , matchers: function (item) {
	  	if(item.name){
	  		return ~item.name.toLowerCase().indexOf(this.query.toLowerCase())
	   	} else return false;
    }
  , sorter: function (items) {
      var beginswith = []
        , caseSensitive = []
        , caseInsensitive = []
        , item

      while (item = items.shift()) {
        if (!item.name.toLowerCase().indexOf(this.query.toLowerCase())) beginswith.push(item)
        else if (~item.name.indexOf(this.query)) caseSensitive.push(item)
        else caseInsensitive.push(item)
      }

      return beginswith.concat(caseSensitive, caseInsensitive)
    }
  , highlighter: function (item) {
      var query = this.query.replace(/[\-\[\]{}()*+?.,\\\^$|#\s]/g, '\\$&')
      return item.replace(new RegExp('(' + query + ')', 'ig'), function ($1, match) {
        return '<strong>' + match + '</strong>'
      })
    }

  , render: function (items) {
      var that = this

      items = $(items).map(function (i, item) {
        i = $(that.options.item).attr('data-value', item.name).attr('data-id', item.id);
        i.find('a').html(that.highlighter(item.name))
        return i[0]
      })

      items.first().addClass('active')
      this.$menu.html(items)
      return this
    }
//---------------------------------------------------------------
/*  , process: function (items) {
	  var that = this
	  
	  items = $.grep(items, function (item) {
		  return that.matcher(item)
	  })
	  
	  items = this.sorter(items)
	  
	  if (!items.length) {
		  return this.shown ? this.hide() : this
	  }
	  
	  return this.render(items.slice(0, this.options.items)).show()
  }
  
  , matcher: function (item) {
	  return ~item.toLowerCase().indexOf(this.query.toLowerCase())
  }

  , sorter: function (items) {
      var beginswith = []
        , caseSensitive = []
        , caseInsensitive = []
        , item

      while (item = items.shift()) {
        if (!item.toLowerCase().indexOf(this.query.toLowerCase())) beginswith.push(item)
        else if (~item.indexOf(this.query)) caseSensitive.push(item)
        else caseInsensitive.push(item)
      }

      return beginswith.concat(caseSensitive, caseInsensitive)
    }
  , highlighter: function (item) {
      var query = this.query.replace(/[\-\[\]{}()*+?.,\\\^$|#\s]/g, '\\$&')
      return item.replace(new RegExp('(' + query + ')', 'ig'), function ($1, match) {
        return '<strong>' + match + '</strong>'
      })
    }

  , render: function (items) {
      var that = this

      items = $(items).map(function (i, item) {
        i = $(that.options.item).attr('data-value', item)
        i.find('a').html(that.highlighter(item))
        return i[0]
      })

      items.first().addClass('active')
      this.$menu.html(items)
      return this
    }
*/

  , next: function (event) {
      var active = this.$menu.find('.active').removeClass('active')
        , next = active.next()

      if (!next.length) {
        next = $(this.$menu.find('li')[0])
      }

      next.addClass('active')
    }

  , prev: function (event) {
      var active = this.$menu.find('.active').removeClass('active')
        , prev = active.prev()

      if (!prev.length) {
        prev = this.$menu.find('li').last()
      }

      prev.addClass('active')
    }

  , listen: function () {
      this.$element
        .on('focus',    $.proxy(this.focus, this))
        .on('blur',     $.proxy(this.blur, this))
        .on('keypress', $.proxy(this.keypress, this))
        .on('keyup',    $.proxy(this.keyup, this))

      if (this.eventSupported('keydown')) {
        this.$element.on('keydown', $.proxy(this.keydown, this))
      }

      this.$menu
        .on('click', $.proxy(this.click, this))
        .on('mouseenter', 'li', $.proxy(this.mouseenter, this))
        .on('mouseleave', 'li', $.proxy(this.mouseleave, this))
    }

  , eventSupported: function(eventName) {
      var isSupported = eventName in this.$element
      if (!isSupported) {
        this.$element.setAttribute(eventName, 'return;')
        isSupported = typeof this.$element[eventName] === 'function'
      }
      return isSupported
    }

  , move: function (e) {
      if (!this.shown) return

      switch(e.keyCode) {
        case 9: // tab
        case 13: // enter
        case 27: // escape
          e.preventDefault()
          break

        case 38: // up arrow
          e.preventDefault()
          this.prev()
          break

        case 40: // down arrow
          e.preventDefault()
          this.next()
          break
      }

      e.stopPropagation()
    }

  , keydown: function (e) {
      this.suppressKeyPressRepeat = ~$.inArray(e.keyCode, [40,38,9,13,27])
      this.move(e)
    }

  , keypress: function (e) {
      if (this.suppressKeyPressRepeat) return
      this.move(e)
    }

  , keyup: function (e) {
      switch(e.keyCode) {
        case 40: // down arrow
        case 38: // up arrow
        case 16: // shift
        case 17: // ctrl
        case 18: // alt
          break

        case 9: // tab
        case 13: // enter
          if (!this.shown) return
          this.select()
          break

        case 27: // escape
          if (!this.shown) return
          this.hide()
          break

        default:
          this.lookup()
      }

      e.stopPropagation()
      e.preventDefault()
  }

  , focus: function (e) {
      this.focused = true
    }

  , blur: function (e) {
      this.focused = false
      if (!this.mousedover && this.shown) this.hide()
    }

  , click: function (e) {
      e.stopPropagation()
      e.preventDefault()
      this.select()
      this.$element.focus()
    }

  , mouseenter: function (e) {
      this.mousedover = true
      this.$menu.find('.active').removeClass('active')
      $(e.currentTarget).addClass('active')
    }

  , mouseleave: function (e) {
      this.mousedover = false
      if (!this.focused && this.shown) this.hide()
    }

  }


  /* TYPEAHEAD PLUGIN DEFINITION
   * =========================== */

  var old = $.fn.typeaheadwu

  $.fn.typeaheadwu = function (option) {
    return this.each(function () {
      var $this = $(this)
        , data = $this.data('typeahead')
        , options = typeof option == 'object' && option
      if (!data) $this.data('typeahead', (data = new Typeaheadwu(this, options)))
      if (typeof option == 'string') data[option]()
    })
  }

  $.fn.typeaheadwu.defaults = {
    source: []
  , items: 8
  , menu: '<ul class="typeahead dropdown-menu"></ul>'
  , item: '<li><a href="#"></a></li>'
  , minLength: 1
  }

  $.fn.typeaheadwu.Constructor = Typeaheadwu


 /* TYPEAHEAD NO CONFLICT
  * =================== */

  $.fn.typeaheadwu.noConflict = function () {
    $.fn.typeaheadwu = old
    return this
  }


 /* TYPEAHEAD DATA-API
  * ================== */

  $(document).on('focus.typeahead.data-api', '[data-provide="typeahead"]', function (e) {
    var $this = $(this)
    if ($this.data('typeahead')) return
    $this.typeaheadwu($this.data())
  })

}(window.jQuery);
