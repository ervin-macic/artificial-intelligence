(define (domain hanoi)

  (:requirements :strips :typing)

  (:types
    thing
    disk - thing
  )

  (:predicates
    (on ?x - disk ?y - thing)
    (clear ?x - thing)
    (smaller ?x - disk ?y - thing)
  )

  (:action move
    :parameters (?d - disk ?from - thing ?to - thing)
    :precondition
      (and
        (on ?d ?from)
        (clear ?d)
        (clear ?to)
        (smaller ?d ?to)
      )
    :effect
      (and
        (not (on ?d ?from))
        (on ?d ?to)
        (clear ?from)
        (not (clear ?to))
      )
  )

)