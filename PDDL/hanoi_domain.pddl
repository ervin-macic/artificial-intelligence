(define (domain hanoi)

  (:requirements :strips :typing)

  (:types
    disk
    rod
  )

  (:predicates
    (on ?x - disk ?y - disk)
    (bottom ?x - disk ?r - rod)
    (clear ?x - disk)
    (empty ?r - rod)
    (smaller ?x - disk ?y - disk)
  )

  ;; move top disk from one disk onto another disk
  (:action move-disk-disk
    :parameters (?x - disk ?y - disk ?z - disk)
    :precondition
      (and
        (on ?x ?y)
        (clear ?x)
        (clear ?z)
        (smaller ?x ?z)
      )
    :effect
      (and
        (not (on ?x ?y))
        (on ?x ?z)
        (clear ?y)
        (not (clear ?z))
      )
  )

  ;; move bottom disk from a rod onto a disk
  (:action move-rod-disk
    :parameters (?x - disk ?r - rod ?z - disk)
    :precondition
      (and
        (bottom ?x ?r)
        (clear ?x)
        (clear ?z)
        (smaller ?x ?z)
      )
    :effect
      (and
        (not (bottom ?x ?r))
        (on ?x ?z)
        (empty ?r)
        (not (clear ?z))
      )
  )

  ;; move top disk from a disk onto an empty rod
  (:action move-disk-rod
    :parameters (?x - disk ?y - disk ?r - rod)
    :precondition
      (and
        (on ?x ?y)
        (clear ?x)
        (empty ?r)
      )
    :effect
      (and
        (not (on ?x ?y))
        (bottom ?x ?r)
        (clear ?y)
        (not (empty ?r))
      )
  )

  ;; move bottom disk from one rod to another empty rod
  (:action move-rod-rod
    :parameters (?x - disk ?r1 - rod ?r2 - rod)
    :precondition
      (and
        (bottom ?x ?r1)
        (clear ?x)
        (empty ?r2)
      )
    :effect
      (and
        (not (bottom ?x ?r1))
        (bottom ?x ?r2)
        (empty ?r1)
        (not (empty ?r2))
      )
  )

)